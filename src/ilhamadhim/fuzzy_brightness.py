import numpy as np
import skfuzzy as fuzz
from skfuzzy import control as ctrl
import matplotlib.pyplot as plt

# =======================================================
#  PROGRAM FOR AUTO ADJUST HOME'S LAMPS BRIGHTNESS
# =======================================================    

def main(electricity):
    # The universe of variables and membership functions
    electricity_used = ctrl.Antecedent(np.arange(0,1000,5), 'electricity_used')
    brightness = ctrl.Consequent(np.arange(0,100,1), 'brightness')

    # Set limitation of each classification 
    electricity_used['very_low'] = fuzz.trapmf(electricity_used.universe, [0,0,100,150])
    electricity_used['low'] = fuzz.trimf(electricity_used.universe, [100,225,350])
    electricity_used['medium'] = fuzz.trimf(electricity_used.universe, [300,475,650])
    electricity_used['high'] = fuzz.trimf(electricity_used.universe, [550,675,800])
    electricity_used['very_high'] = fuzz.trapmf(electricity_used.universe, [700,750,850,1000])


    brightness['very_low'] = fuzz.trapmf(brightness.universe, [0,0,15,30])
    brightness['low'] = fuzz.trimf(brightness.universe, [15,30,45])
    brightness['medium'] = fuzz.trimf(brightness.universe, [35,55,75])
    brightness['high'] = fuzz.trimf(brightness.universe, [60,75,90])
    brightness['very_high'] = fuzz.trapmf(brightness.universe, [80,85,90,100])

    # RULES OF ADJUSTING THE BRIGHTNESS WITH GIVEN electricity_used
    rule1 = ctrl.Rule(electricity_used['very_low'] , brightness['very_high'])
    rule2 = ctrl.Rule(electricity_used['low'] , brightness['high'])
    rule3 = ctrl.Rule(electricity_used['medium'] , brightness['medium'])
    rule4 = ctrl.Rule(electricity_used['high'] , brightness['low'])
    rule5 = ctrl.Rule(electricity_used['very_high'] , brightness['very_low'])

    # Apply the defined rules into control system
    brightness_ctrl = ctrl.ControlSystem([rule1,rule2,rule3,rule4,rule5])
    adjusting = ctrl.ControlSystemSimulation(brightness_ctrl)

    # use the electricity passed from controller in app.py 
    # In app.py , the value of electricity is acquired from input in the website
    adjusting.input['electricity_used'] = int(electricity)

    try:
        # Simulate the whole fuzzy process based on the rules and input given from the website
        adjusting.compute()
        output = adjusting.output['brightness']

        print("With electricity used : ", electricity, " KWH")
        print("Output of brightness is : ", '%.2f' % output, "%")

    except Exception:
        print("Electricity out of bound")
    return output


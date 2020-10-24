import rospy
from std_msgs.msg import string

def callback(dat):
    word = dat.data
    rospy.loginfo(word)

if __name__ == '__main__':
    rospy.init_node("simple_publisher_node")
    try:
        rospy.Subscribe('/hello', String, callback)
        rospy.spin()
    except rospy.ROSInterruptException:
        pass
user_id = 0
loop = "n"
user =  [
            {   
                "id":"1234",
                "no_rekening":"1234567890",
                "username":"Eka Prasetyo",
                "pin":"4321",
                "saldo":0
            },
            {   
                "id":"4321",
                "no_rekening":"0987654321",
                "username":"Eko Prasetyo",
                "pin":"1234",
                "saldo":25000000
            }
        ]
status_login = False
pakai_atm = "y"
 
def cek_login(p):
    for us in user:
        if us['pin'] == p:
            return us
    return False       
     
def cek_user(id):
    for i in range(len(user)):
        if user[i]['id'] == str(id):
            return int(i)
    return -1
 
def cek_rekening(no):
    for i in range(len(user)):
        if str(user[i]['no_rekening']) == str(no):
            return int(i)
    return -1
 
def tranfer_uang(uang,no_rekening):
    index1 = cek_user(user_id)
    index2 = cek_rekening(no_rekening)
    if index1 >= 0:
        if user[index1]['saldo'] >= int(uang):
            user[index1]['saldo'] =user[index1]['saldo'] - int(uang)
            user[index2]['saldo'] =user[index2]['saldo'] + int(uang)
            print("Anda berhasil mentransfer uang Rp."+str(uang)+" ke Rekening "+no_rekening)
            print("sisa saldo anda adalah Rp.",user[index1]['saldo'])
        else:
            print("Maaf saldo anda tidak cukup")
             
def ambil_uang(uang):
    index1 = cek_user(user_id)
    if index1 >= 0:
        if user[index1]['saldo'] >= int(uang):
            user[index1]['saldo'] =user[index1]['saldo'] - int(uang) 
            print("Anda berhasil menarik uang Rp."+str(uang))
            print("sisa saldo anda adalah Rp.",user[index1]['saldo'])
        else:
            print("Maaf saldo anda tidak cukup")
 
 
while pakai_atm == "y":
    while status_login == False:
        print("+================================================+")
        print("+SELAMAT DATANG DI APLIKASI ATM BANK KITA BERSAMA+")
        print("+================================================+")
        print("+          Silahkan masukan pin anda             +")
        print("+================================================+")
        pin = input("Masukan PIN :")
       
     
        cl = cek_login(pin)
        if cl != False:
            print("Selamat Datang "+cl['username'])
            user_id = cl['id']
            status_login = True
            loop = "y"
        else:
            print("")
            print("Maaf PIN anda salah")
            print("")
            print("")
     
    while loop == "y" and status_login == True:
        u = user[cek_user(user_id)]
        print("+================================================+")
        print("+SELAMAT DATANG DI APLIKASI ATM BANK KITA BERSAMA+")
        print("+================================================+")
        print("+               1.Cek Saldo                      +")
        print("+               2.Transfer Uang                  +")
        print("+               3.Ambil Uang                     +")
        print("+               4.Ganti PIN                      +")
        print("+               5.Logout                         +")
        print("+               6.Keluar ATM                     +")
        print("+================================================+")
        a = int(input("Silahkan masukkan pilihan anda: "))
        if a == 1:
            print("")
            print("Sisa Saldo anda adalah Rp.",u['saldo'])
            print("")
            print("")
            loop = "n"
        elif a == 2:
            print("Untuk Mentransfer Uang Silahkan Masukan No Rekening Tujuan")
            no_rek = input("Masukan No Rekening Tujuan : ")
            cnk = cek_rekening(no_rek)
             
            if cnk >= 0:
                print("Nomor rekening ditemukan,silahkan masukan nominal yang yang akan di transfer")
                nominal = input("Nominal Yang Akan Di Transfer : ")
                tranfer_uang(nominal,no_rek)
                print("")
                loop = "n"
            else:
                print("")
                print("Nomor Rekening Tujuan Tidak ditemukan atau tidak terdaftar")
                print("")
                loop = "n"
                 
        elif a == 3:
            nominal = input("Nominal Yang Akan Di Tarik : ")
            ambil_uang(nominal)
            print("")
            loop = "n"
        elif a == 4:
            print('-----------------------------')
            print('*****************************')
            pin_baru = input("Silahkan masukkan PIN baru Anda : ")
            print('*****************************')
            print('-----------------------------')
            if pin_baru.isdigit() and pin_baru != pin and len(pin_baru) == 4:
                print('------------------')
                print('******************')
                pin_baru1 = input("Konfirmasi Password Baru : ")
                print('*******************')
                print('-------------------')
                if pin_baru1 != pin_baru:
                    print('------------')
                    print('************')
                    print('PIN tidak Cocok')
                    print('************')
                    print('------------')
                else:
                    pin = pin_baru
                    print('PIN baru telah disimpan')
            else:
                print('-------------------------------------')
                print('*************************************')
                print('   PIN baru harus berisi 4 digit \n dan tidak sama dengan PIN lama')
                print('*************************************')
                print('-------------------------------------')
                
        elif a == 5:
            status_login = False
             
        elif a == 6:
            status_login = False
            loop = "n"
            pakai_atm = "n"
        else:
            print("pilihan tidak tersedia")
        if status_login == True:
             
            input("kembali Ke menu (Enter) ")
            print("")
            loop = "y"
 

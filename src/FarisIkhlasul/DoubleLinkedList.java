package uas_smt2;

/**
 *
 * @author Faris Ikhlasul H
 */
public class DoubleLinkedList {

    Node head;
    int size;
    int index;
    public DoubleLinkedList() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(int kode, String nama, String judul, int stock, int rusak) {
        if (isEmpty()) {
            head = new Node(null, nama, judul, kode, stock, rusak, null);
        } else {
            Node newNode = new Node(null, nama, judul, kode, stock, rusak, null);
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(int kode, String nama, String judul, int stock, int rusak) {
        if (isEmpty()) {
            addFirst(kode, nama, judul, stock, rusak);
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            Node newNode = new Node(current, nama, judul, kode, stock, rusak, null);
            current.next = newNode;
            size++;
        }
    }

    public int size() {
        return size;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public void print() {
        if (!isEmpty()) {
            Node tmp = head;
            System.out.print("Index\t");
            System.out.print("Kode\t");
            System.out.print("Judul\t");
            System.out.print("Distributor\t");
            System.out.print("Stock\t");
            System.out.print("Rusak");
            while (tmp != null) {
                System.out.print(index);
                System.out.print(tmp.kode);
                System.out.print(tmp.judul);
                System.out.print(tmp.nama);
                System.out.print(tmp.stock);
                System.out.print(tmp.rusak);
                tmp = tmp.next;
            }
            System.out.println();

        } else {
            System.out.println("CD tidak ditemukan / kosong");
        }
    }

    public void removeFirst() throws Exception {
        if (isEmpty()) {
            throw new Exception("Linked List masih Kosong, tidak dapat di hapus!");
        } else if (size == 1) {
            removeLast();
        } else {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    public void removeLast() throws Exception {
        if (isEmpty()) {
            throw new Exception("Linked	List Masih Kosong, Tidak Dapat Dihapus!");
        } else if (head.next == null) {
            head = null;
            size--;
            return;
        }
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
        size--;
    }

    public void remove(int index) throws Exception {
        if (isEmpty() || index >= size) {
            throw new Exception("Nilai indeks di luar batas!");
        } else if (index == 0) {
            removeFirst();
        } else {
            Node current = head;
            int i = 0;
            while (i < index) {
                current = current.next;
                i++;
            }
            if (current.next == null) {
                current.prev.next = null;
            } else if (current.prev == null) {
                current = current.next;
                current.prev = null;
                head = current;
            } else {
                current.prev.next = current.next;
                current.next.prev = current.prev;
            }
            size--;
        }
    }

    public String getFirst() throws Exception {
        if (isEmpty()) {
            throw new Exception("Linked List kosong!");
        }
        String kata = "";
        kata += "Kode : " +"Judul : " +"Jumlah Stock : "+"Jumlah Rusak : ";
        return kata;
    }

    public String getLast() throws Exception {
        if (isEmpty()) {
            throw new Exception("Linked List kosong!");
        }
        Node tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        String kata = "";
        kata += "Kode : " +"Judul : " +"Jumlah Stock : "+"Jumlah Rusak : ";
        return kata;
    }

    public String get(int index) throws Exception {
        if (isEmpty() || index >= size) {
            throw new Exception("Linked List kosong!");
        }
        Node tmp = head;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        String kata = "";
        kata += "Kode : " +"Judul : " +"Jumlah Stock : "+"Jumlah Rusak : ";
        return kata;
    }

    public int pencarian(int kodecari) throws Exception {
        if (isEmpty()) {
            throw new Exception("LinkedLis Kosong");
        }
        int j = 0;
        Node tmp = head;
        if (kodecari == tmp.kode) {
            j = 0;
        } else {
            for (int i = 0; i < size; i++) {
                tmp = tmp.next;
                j++;
                if (kodecari == tmp.kode) {
                    break;
                }
            }
        }
        return j;
    }
    public void Urut() {
        int swapped;
        Node cur;
        if (isEmpty()) {
            System.out.println("LinkedList dalam keadaan kosong");
        } else {
            do {
                swapped = 0;
                cur = head;
                while (cur.next != null) {
                    if (cur.kode < cur.next.kode) {
                        int tempkode = cur.next.kode;
                        String tempNama = cur.next.nama;
                        cur.next.nama = cur.nama;
                        cur.next.kode = cur.kode;
                        cur.nama = tempNama;
                        cur.kode = tempkode;
                        swapped = 1;
                    }
                    cur = cur.next;
                }
            } while (swapped == 1);
        }
    }
}

import java.util.Scanner;

public class AplikasiTodolist {

    public static String[] lists = new String[10];

    public static Scanner scanner = new Scanner(System.in);

    public static void main (String[] args) {
        viewShowList();
    }

    // menerima input dari user
    public static String input (String info) {
        System.out.print(info + ": ");
        String data = scanner.nextLine();
        return data;
    }

    public static void testInput(){
        var data = input("nama");
        System.out.println("Hi " + data);
    }

    /**
     * menampilkan todo list
     */
    public static void showLists (){
        System.out.println("TO DO LIST APP \n");

        for (var i = 0; i < lists.length; i++ ) {
            var list = lists[i];
            var no = i + 1;

            if(list != null){
                System.out.println(no + ". " + list);
            }
        }
    }

    public static void testShowTodoList(){
        lists[0] = "Belajar Java Dasar";
        showLists();
    }

    /**
     * menambah todo list
     */
    public static void addList(String list){
        //cek apakah ada indeks yang masih kosong
        var isFull = true;
        for (int i = 0; i < lists.length; i++) {
            if(lists[i] == null){
                isFull = false;
                break;
            }
        }

        //jika lists sudah penuh, resize lists ke 2x ukuran semula
        if (isFull){
            var temp = lists;
            lists = new String[lists.length * 2];

            for (int i = 0; i < temp.length; i++) {
                lists[i] = temp[i];
            }
        }

        //masukkan list ke array list
        for (int i = 0; i < lists.length; i++) {
            if(lists[i] == null){
                lists[i] = list;
                break;
            }
        }
    }

    public static void testAddList(){
        for (int i = 0; i < 25; i++) {
            addList("contoh todo ke: " + i);
        }
        showLists();
    }

    /**
     * memnghapus todo list
     */
    public static boolean removeList(Integer number){
        if((number - 1) >= lists.length){
            return false;
        } else if(lists[number -1] == null){
            return false;
        } else {
            for (int i = (number - 1); i < lists.length ; i++) {
                if(i == (lists.length - 1)){
                    lists[i] = null;
                } else {
                    lists[i] = lists[i + 1];
                }
            }
            return true;
        }
    }

    public static void testRemoveList(){
        addList("satu");
        addList("Dua");
        addList("Tiga");

        var result = removeList(20);
        System.out.println(result);

        result = removeList(4);
        System.out.println(result);

        result = removeList(1);
        System.out.println(result);

        showLists();
    }

    /**
     * menampilkan view todo list
     */
    public static void viewShowList(){
        while(true){
            showLists();

            System.out.println("MENU: ");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("99. Keluar");

            var input = input("Pilih ");

            if(input.equals("1")){
                viewAddList();
            } else if ( input.equals("2")){
                viewRemoveList();
            } else if ( input.equals("99")){
                break;
            } else {
                System.out.println("Pilihan tidak dimengerti!");
            }
        }
    }

    public static void testViewShowList (){
        addList("Satu");
        addList("Dua");
        addList("Tiga");
        addList("Empat");
        addList("Lima");
        viewShowList();
    }

    /**
     * menampilkan view add todo list
     */
    public static void viewAddList(){
        System.out.println("MENAMBAH TODO LIST");

        var list = input("Todo List (x jika batal)");

        if (list.equals("x")){
            //batal
        } else {
            addList(list);
        }
    }

    public static void TestShowViewAddList(){
        addList("Satu");
        addList("Dua");
        addList("Tiga");
        addList("Empat");
        addList("Lima");

        viewAddList();

        showLists();
    }

    /**
     * menampilkan view remove todo list
     */
    public static void viewRemoveList(){
        System.out.println("MENGHAPUS TODO LIST");

        var number = input("Nomor yang dihapus (x jika batal) ");

        if (number.equals("x")){
            //batal
        } else {
            boolean success = removeList(Integer.valueOf(number));
            if(!success){
                System.out.println("Gagal Menghapus Todo List: " + number);
            }
        }
    }

    public static void testViewRemoveList(){
        addList("Satu");
        addList("Dua");
        addList("Tiga");
        addList("Empat");
        addList("Lima");

        showLists();
        viewRemoveList();
        showLists();
    }
}

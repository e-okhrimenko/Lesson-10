public class AnIteratorOverAnArray {
    public static void main(String[] args) {
        //Написать итератор по массиву(не коллекции), размер массива заваетя через конструктор

        Object[] object = new Object[10];
        object[0] = "object 00";
        object[1] = "object 01";
        object[2] = "object 02";
        object[3] = "object 03";
        object[4] = "object 04";
        object[5] = "object 05";
        object[6] = "object 06";
        object[7] = "object 07";
        object[8] = "object 08";
        object[9] = "object 09";

        String[] strings = new String[10];
        strings[0] = "string 00";
        strings[1] = "string 01";
        strings[2] = "string 02";
        strings[3] = "string 03";
        strings[4] = "string 04";
        strings[5] = "string 05";
        strings[6] = "string 06";
        strings[7] = "string 07";
        strings[8] = "string 08";
        strings[9] = "string 09";

        MyIterator myIterator = new MyIterator(object);
        while (myIterator.hasNext()) {
            System.out.println(myIterator.next());
        }

        System.out.println();

        MyIterator myIterator1 = new MyIterator(strings);
        while (myIterator1.hasNext()) {
            System.out.println(myIterator1.next());
        }
    }


    private static class MyIterator {
        private final Object[] array;
        private int index = 0;

        MyIterator(Object[] array) {
            this.array = array;
        }

        public boolean hasNext() {
            return index < array.length;
        }

        public Object next() {
            if (hasNext()) {
                return array[index++];
            }
            return null;
        }
    }
}
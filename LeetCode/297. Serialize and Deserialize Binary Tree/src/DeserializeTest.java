public class DeserializeTest {
    static String input = "1 2 4 null 9 null null 5 10 null null 11 null null 3 6 null null 7 12 null null null ";

    public static void main(String[] args) {
        TreeNode deserialize = new Codec().deserialize(input);
        System.out.println(deserialize);
        System.out.println(new Codec().serialize(deserialize));
        System.out.println(new Codec().deserialize("1 null null "));
    }
}

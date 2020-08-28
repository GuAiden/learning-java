package beginner_learning;
public class HelloWorld
{
   public static void main(final String args[])
    {
        System.out.println("Hello World");
        int a = 3;
        int b = 2;
        
        // Testing conditionals
        if ((a+b) == 5) {
            System.out.println(a+b);
        }

        // Testing arrays, 
        int[] arr = new int[10];
        System.out.println("Array len is " + arr.length);
        print_line();
        System.out.println("Printing out an array that increases by 4 at every even number");
        int i = 0;
        for (int idx = 0; idx < arr.length; idx++) {
            arr[idx] = i+1;
            i++;
            if (i % 2 == 0) {
                i += 3; 
            }
            System.out.println(arr[idx]);
        }
        // Testing function calls, 
        String c = "Testing function calls\n" + "Sum is " + sum(a, b); 
        cool_print(c);

        // Testing out classes, 
        System.out.println("Testing Classes ");
        Bender aang = new Bender();
        aang.setName("Avatar Aang");
        System.out.println("Bender Name: " + aang.getName());
        aang.setElement("All");
        System.out.println("Bender Element: " + aang.getElement());
        aang.setPower(1000); 
        System.out.println("Bender Power: " + aang.getPower());
        print_line();
    }

    public static int sum(int a, int b) {
        return a + b;
    }

    public static void cool_print(String a) {
        print_line();
        System.out.println(a);
        print_line();
    }

    public static void print_line() {
        System.out.println("-----------------------");
    }
    
}

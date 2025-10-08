class prime {
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        } else {
            for (int i = 2; i < (num / 2); i++) {
                if (num % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String args[]) {
        if (args.length == 0) {
            System.out.println("please enter the command line arguments");
        }
        int num = 0;
        for (int i = 0; i < args.length; i++) {
            num = Integer.parseInt(args[i]);
            if (isPrime(num)) {
                System.out.println(num + " is a prime number");
            }else{
                System.out.println(num + " is not prime number");
            }
        }
    }
}

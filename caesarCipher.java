import java.util.Scanner;

public class caesarCipher {
    /* This method is used to both encrypt and decrypt */
    public static String encrypt(String input, int key1, int key2) {
        int pos = -1, pos1 = -1;
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; /* Take whole alphabet as a string */
        /* modify the encrypted string use string builder */
        StringBuilder encrypted = new StringBuilder(input);
        for (int i = 0; i < encrypted.length(); i++) {
            /* take each character from the string */
            char sample = encrypted.charAt(i);
            /* We have to perform only with alphabet */
            if (Character.isAlphabetic(sample)) {
                /* check the position as key1 for even and key2 for odd position */
                if (i % 2 == 0) {
                    /*
                     * if the character is uppercase nothing to do
                     * cause we take alphabet in total uppercase
                     */
                    if (Character.isUpperCase(sample)) {
                        /* find the position of the character from the alphabet */
                        pos = alphabet.indexOf(sample);
                        /* set the position as key */
                        pos = (pos + key1) % 26;
                        /* find the letter with updated position from the alphabet */
                        char res = alphabet.charAt(pos);
                        /* modify it */
                        encrypted.setCharAt(i, res);

                    }
                    /* if the character is in lowercase */
                    else {
                        /* convert it to uppercase to find */
                        pos = alphabet.indexOf(Character.toUpperCase(sample));
                        pos = (pos + key1) % 26;
                        char res = alphabet.charAt(pos);
                        /* convert the desired output in lowercase then modify it */
                        encrypted.setCharAt(i, Character.toLowerCase(res));

                    }
                    pos = -1;
                }
                /* same above procedure in case of odd position */
                else {
                    if (Character.isUpperCase(sample)) {
                        pos1 = alphabet.indexOf(sample);
                        pos1 = (pos1 + key2) % 26;
                        char res1 = alphabet.charAt(pos1);
                        encrypted.setCharAt(i, res1);

                    } else {
                        pos1 = alphabet.indexOf(Character.toUpperCase(sample));
                        pos1 = (pos1 + key2) % 26;
                        char res1 = alphabet.charAt(pos1);
                        encrypted.setCharAt(i, Character.toLowerCase(res1));

                    }
                    pos1 = -1;
                }
            }
        }
        return encrypted.toString();

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string:");
        String input = sc.nextLine();
        System.out.println("Enter the key1:");
        int key1 = sc.nextInt();
        System.out.println("Enter the key2:");
        int key2 = sc.nextInt();
        /*
         * for both encryt and decrypt use the same method but for decrypt key will be
         * 26-key
         */
        String e = encrypt(input, key1, key2);
        System.out.println("...........After encryption...........\n" + e);
        String d = encrypt(e, (26 - key1), (26 - key2));
        System.out.println("...........After decryption...........\n" + d);
    }

}
/* Compile and enjoy */
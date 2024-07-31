//M NACCACHE: This program calculates the lowest common denomonator for two fractions

public class TestCommon {
    
    public static void main (String[] args) { //the main method of this program
    
        ManagerCommon.calculate(1, 2, 3, 4); //first numerator, first denomonator, second numerator, second denomonator
        ManagerCommon.calculate(5, 6, 7, 8);//don't set the denomonators as 0, and don't make them negetives for my own sanity please
        ManagerCommon.calculate(23, 19, 38, 92); //this is just a super mild stress test, you can't go too long or it does an integer overflow and break

    }
}

class ManagerCommon {

    public static void calculate (int firstN, int firstD, int secondN, int secondD) { //this is the main method of the manager class, aka it moves things around and prints stuff out while other methods actually do the leg work of the program
        System.out.printf("The common deconenator between %d/%d and %d/%d is ", 
                        firstN, firstD, secondN, secondD);

        int answer = ManagerCommon.firstDivide(firstD, secondD); //adks the other methods what the lowest common number is

        System.out.printf("%d, which gives us %d/%d and %d/%d\n", 
                        answer, (firstN * (answer / firstD)), answer, 
                        (secondN * (answer / secondD)), answer); //prints out the answer and the fractions fully calculated to be the lowest common denomonator
    }

    public static int firstDivide (int firstD, int secondD) { //tests if they are the same number, and if either are 1 just to get it out of the way since those are easy. Then it hands it off to the recursive method
        if (firstD == secondD) { //are the denomonators the same?
            return firstD;
        } else if (firstD == 1 || secondD == 1) { //are either of the denomonators 1?
            return (firstD * secondD);
        }

        return secondDivide(firstD, secondD, 1); //if it isn't either of the above, start doing recursive. ()
    }

    public static int secondDivide (int firstD, int secondD, int multiply) { //recursive method, sees if secondD is a factor of firstD * multiply. If it isn't, then up the multiply by one and try again until it is true
        if (((firstD * multiply) % secondD) == 0) { //is secondD a factor of firstD * multiply?
            return (firstD * multiply); //if yes, return that number
        }

        multiply++; //if not, up multiply by one and try again!
        return secondDivide(firstD, secondD, multiply);
    }

}

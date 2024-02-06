// j2 from 'macros.j2' import header
// {{ header("Lokale Klassen", "Local Classes") }} 

// %% [markdown] lang="en" tags=["slide"]
// ## Declaring Local Classes
// 
// - Local classes are classes that are defined in a block, which is a group of zero or more statements between balanced braces.
// - These classes are typically found defined in the body of a method.
// - You can define a local class inside any block. This could be a method body, a for loop, or an if clause.

// %% tags=["start"]
public class PhoneNumberValidator {
  
    static String regularExpression = "[^0-9]";
  
    public static void validatePhoneNumber(String phoneNumber1) {
      
        final int numberLength = 10;
       
        // to be implemented
    }
}

// %% tags=["alt"]
public class PhoneNumberValidator {
  
    static String regularExpression = "[^0-9]";
  
    public static void validatePhoneNumber(String phoneNumber1) {
      
        final int numberLength = 10;
       
        class PhoneNumber {
            
            String formattedPhoneNumber = null;

            PhoneNumber(String phoneNumber){
                
                String currentNumber = phoneNumber.replaceAll(
                  regularExpression, "");
                if (currentNumber.length() == numberLength)
                    formattedPhoneNumber = currentNumber;
                else
                    formattedPhoneNumber = null;
            }

            public String getNumber() {
                return formattedPhoneNumber;
            }
        }
        
        PhoneNumber myNumber1 = new PhoneNumber(phoneNumber1);

        if (myNumber1.getNumber() == null) 
            System.out.println("First number is invalid");
        else
            System.out.println("First number is " + myNumber1.getNumber());        
    }
}

// %% 
PhoneNumberValidator.validatePhoneNumber("0134567890")

// %% [markdown] lang="en" tags=["slide"]
// ## Accessing Members of an Enclosing Class
// - A local class has access to the members of its enclosing class. 
//      - For example, the PhoneNumber constructor accesses the member LocalClassExample.regularExpression.
// - A local class can only access local variables that are declared final. 
//      -  This type of variable is known as a captured variable.
// - However, starting in Java SE 8, a local class can access local variables and parameters of the enclosing block that are final or effectively final. 

// %% [markdown] lang="en" tags=["slide"]
// ## Shadowing and Local Classes
// - Declarations of a type (such as a variable) in a local class shadow declarations in the enclosing scope that have the same name.

// %% [markdown] lang="en" tags=["slide"]
// ## Local Classes Are Similar To Inner Classes
// - Local classes are similar to inner classes because they cannot define or declare any static members.
// - Local classes in static methods such as PhoneNumber defined in the static method validatePhoneNumber, can only refer to static members of the enclosing class.
// - These classes are non-static because they have access to instance members of the enclosing block. Therefore, they cannot contain most kinds of static declarations.

// %% [markdown] lang="en" tags=["slide"]
// A local class can have static members provided that they are constant variables

// %% tags=["keep"]
public void sayGoodbyeInEnglish() {
        class EnglishGoodbye {
            public static final String farewell = "Bye bye";
            public void sayGoodbye() {
                System.out.println(farewell);
            }
        }
        EnglishGoodbye myEnglishGoodbye = new EnglishGoodbye();
        myEnglishGoodbye.sayGoodbye();
}
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        // Uncomment this block to pass the first stage
        Scanner scanner = new Scanner(System.in);
        int flag = 0;
        while(flag == 0){
            System.out.print("$ ");
            String input = scanner.nextLine();
            String[] commands = input.split(" ",2);
            String[] builtin = {"echo", "exit", "type"};
            String arg = "";
            Boolean valid = false;
            if(commands.length>1){
                arg = commands[1];
            }
            switch(commands[0]){

                case "exit":
                    if(arg.equals("0")){
                        flag = 1;
                        valid = true;
                    }
                    break;


                case "echo":
                    if(!arg.equals("")){
                        System.out.println(arg);
                        valid=true;
                    }
                    break;
                
                case "type":
                    if(arg.equals("")){
                        valid = false;
                    }
                    else{
                        if(Arrays.asList(builtin).contains(arg)){
                            System.out.println(arg +" is a shell builtin");
                        }
                        else{
                            System.out.println(arg+": not found");
                        }
                        valid = true;
                    }
                    break;
                    
                case ""
        
            }
            if(!valid){
                System.out.println(input+": command not found");
            }
            // if(commands[0].equals("echo") && commands.length>1){
            //     System.out.println(commands[1]);
            // }else if(commands[0].equals("type") && commands.length>1 ){
                // if(Arrays.asList(builtin).contains(commands[1])){
                //     System.out.println(commands[1] +" is a shell builtin");
                // }
                // else{
                //     System.out.println(commands[1]+": not found");
                // }
            // }
            // else if(input.equals("exit 0")){
            //     break;
            // }
            // else{
            //     System.out.println(input+": command not found");
            // }
        }
    }
}
package com.company;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

    public class Main {

            public static void main(String[] args) {
            // write your code here
                    Scanner sc = new Scanner(System.in);

                    System.out.println("Welcome to the store, Hello, I am Eliza, How may I help you Today ?");
                    System.out.println(" ================================== ");
                    System.out.println("Enter your Response here or Enter 'Q' to End the chat?");
                    String s1 = sc.nextLine();
                    String message = "";

                    while (!s1.toLowerCase().equals("q")) {
                        String[] input = (s1.split(" "));

                        message="";


                        for (int i = 0; i < input.length; i++) {
                            String replace = getReplace(input[i]);
                            if (input[i].equalsIgnoreCase("I")) {
                                input[i] = input[i].replace("I", replace);
                            } else if (input[i].equalsIgnoreCase("me")) {
                                input[i] = input[i].replace("me", replace);
                            } else if (input[i].equalsIgnoreCase("my")) {
                                input[i] = input[i].replace("my", replace);
                            } else if (input[i].equalsIgnoreCase("am")) {
                                input[i] = input[i].replace("am", replace);
                            } else if (input[i].equalsIgnoreCase("you")) {
                                input[i] = input[i].replace("you", replace);
                            } else {
                                input[i] = input[i];
                            }
                            message += (input[i] + " ");
                        }
                        //checking if the input contain key words
                        if  ((s1.contains("I")) || (s1.contains("my")) || (s1.contains("me"))
                                || (s1.contains("am")) || (s1.contains("you"))){
                            //calling method to get qualifier
                            String qu = getQualif();
                            //Printing the Qualifier message
                            System.out.print(qu + " " + message);
                            s1 = sc.nextLine();
                        }
                        else {
                            //calling method to get a hedge
                            String hed = getHedge();
                            //Printing the hedge
                            System.out.println(hed);
                            s1 = sc.nextLine();
                        }


                    }
                    System.out.println("Thank You");
                }
                //method for random pickup
                public static  String getReplace(String  key) {
                    HashMap<String, String> replacement = new HashMap<>();
                    replacement.put("i", "you");
                    replacement.put("me", "your");
                    replacement.put("am", "are");
                    replacement.put("my", "your");
                    replacement.put("you", "me");
                    String rp=replacement.get(key);
                    return rp;
                }

                public static  String getQualif(){
                    Random ran = new Random();
                    HashMap<Integer, String> qualif = new HashMap<Integer, String>();
                    qualif.put( 1, "Why do you say that");
                    qualif.put(2, "You seem to think that");
                    qualif.put(3, "So you are concerned that");
                    qualif.put(4, "So you are concerned that");

                    int qual = ran.nextInt(qualif.size());
                    String quali =qualif.get(qual+1);
                    return quali;

                }
                public static String  getHedge(){
                    Random ran = new Random();
                    HashMap<Integer, String> hedge = new HashMap<>();
                    hedge.put( 1, "Please tell me more");
                    hedge.put(2, "Many of my patients tell me the same thing It is getting late");
                    hedge.put(3, "Maybe we better quit");
                    hedge.put(4, "I think we should go now");

                    int he = ran.nextInt(hedge.size());
                    String hed= hedge.get(he+1);
                    return hed;



                }

            }

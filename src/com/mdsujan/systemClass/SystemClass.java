package com.mdsujan.systemClass;

//"Say for your application specific OS and version of Java is needed.
// Say its Ubuntu and Java 8 and above.
// How will you apply this check?"
public class SystemClass {
    public static void main(String[] args) {
        String osName = System.getProperty("os.name");
        String javaVersion = System.getProperty("java.version");
        System.out.println("OS name: "+osName +", Java Version: "+javaVersion);
    }
}

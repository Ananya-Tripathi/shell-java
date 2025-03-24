# Project Overview: Codecrafters Shell (Java)

## Folder Structure

1. **`.codecrafters/`**
   - Contains scripts for compiling (`compile.sh`) and running (`run.sh`) the program.
   - These scripts are used both locally and remotely (on the CodeCrafters platform).

2. **`src/`**
   - Contains the source code of the program.
   - `src/main/java/Main.java`: The entry point of the program. This file contains the `main` method where the shell logic is implemented.

3. **`target/`**
   - Contains compiled classes and packaged artifacts after the Maven build process.
   - `classes/`: Stores compiled `.class` files.
   - `test-classes/`: Stores compiled test classes (not used in this project).

4. **`your_program.sh`**
   - A script to compile and run the program locally. It uses the `.codecrafters/compile.sh` and `.codecrafters/run.sh` scripts.

5. **`pom.xml`**
   - The Maven configuration file. It defines dependencies, build plugins, and the main class (`Main`) for the program.

6. **Other files**
   - `.gitignore`: Specifies files and directories to exclude from version control (e.g., `target/` and `.jar` files).
   - `README.md`: Documentation for the project.
   - `.gitattributes`: Configures Git's handling of line endings and file types.
   - `codecrafters.yml`: Configuration for running the program on the CodeCrafters platform.

---

## Data Flow When the Program is Run

1. **Compilation**
   - The program is compiled using the `your_program.sh` script, which internally calls `.codecrafters/compile.sh`.
   - The `compile.sh` script runs the Maven command:
     ```sh
     mvn -B package -Ddir=/tmp/codecrafters-build-shell-java
     ```
   - Maven compiles the Java source code (`Main.java`) into `.class` files and packages them into a JAR file (`codecrafters-shell.jar`) with dependencies. The JAR is stored in `/tmp/codecrafters-build-shell-java`.

2. **Execution**
   - The `your_program.sh` script then calls `.codecrafters/run.sh` to execute the program.
   - The `run.sh` script runs the JAR file using the `java -jar` command:
     ```sh
     exec java -jar /tmp/codecrafters-build-shell-java/codecrafters-shell.jar "$@"
     ```
   - The `Main` class is executed as the entry point.

3. **Program Logic**
   - The `Main` class starts execution. The `main` method initializes a `Scanner` to read user input from the terminal.
   - The program waits for the user to input a command. For now, the input is read but not processed further.

4. **Output**
   - If the block in `Main.java` is uncommented:
     ```java
     System.out.print("$ ");
     ```
     The program will display a shell prompt (`$ `) before waiting for user input.

5. **Remote Execution**
   - On the CodeCrafters platform, the `.codecrafters/compile.sh` and `.codecrafters/run.sh` scripts are used in the same way to compile and run the program.

---

## Summary of Data Flow
1. **Source Code (`Main.java`)** → Compiled by Maven → Packaged into `codecrafters-shell.jar`.
2. **JAR File (`codecrafters-shell.jar`)** → Executed by `java -jar` → Runs the `Main` class.
3. **User Input** → Read by `Scanner` in `Main.java` → (Future stages will process this input).

This structure ensures that the program can be built and run both locally and on the CodeCrafters platform.
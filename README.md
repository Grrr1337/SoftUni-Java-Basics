# Java Basics Training Projects

Welcome to my Java Basics training projects repository! This collection showcases the intro-projects that I completed as part of a comprehensive Java Basics course at SoftUni, covering all essential aspects of learning the Java syntax programming language.

### Description
Every part of the course contains 'Lab' (theoretical) and 'Exercise' (practical) aspects, each with multiple training exercise assignments

### Technologies and IDE used
- IntelliJ IDEA Comminuty
- JDK 18

## Prerequisites
Make sure you have the following installed on your machine:
- Java Development Kit (JDK) [18]
- Any additional dependencies specified in the project's README or source code comments


### How to Run
The projects are designed for educational purposes and are not intented to be used for end-use/production. But if you really want to make end use


## Steps

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/Grrr1337/SoftUni-Java-Basics.git
2. Navigate to Project Directory:
    ```bash
    cd SoftUni-Java-Basics/[project_folder]
3. Compile the code:
    ```bash
    # This command compiles the Java source code files and places the compiled bytecode in the bin directory.
    javac -d bin src/*.java
3. Create a JAR File:
    ```bash
    # Replace [project_filename] with the desired name for your JAR file and [MainClass] with the main class of your project.
    jar cfe [project_filename].jar [MainClass] -C bin .
4. Run the JAR File:
    ```bash 
    # Example command to run the project
    java -jar [project_filename].jar
## **Technical Description**

*   **Strategy Pattern**: The implementation of this calculator mainly uses the Strategy Pattern, where different operations have their own strategy classes. For example, the strategy class for addition operation is `AdditionOperationStrategy`.  The essence of the Strategy Pattern lies in the ability to create different strategy classes for different operations. For example, for addition operations we can create `AdditionOperationStrategy,` and for subtraction operations we can create `SubtractionOperationStrategy`.

    This means that if new operations, such as cosine or sine, are needed, we can simply create new strategy classes without the need to modify existing code. This embodies the **Open/Closed Principle** in object-oriented design. In this design, having each operation correspond to a class also embodies the **Single Responsibility Principle**.&#x20;
*   **Factory Pattern**:In this context, there is a very important class named `OperationStrategiesFactory`, which is responsible for creating specific computation strategy classes. Its role is to separate the client logic that uses the strategy classes from the logic of creating strategy classes. This means that the client responsible for using the strategy classes, `CalculatorApp`, does not need to concern itself with the specific details of how the strategy classes are created; it only needs to use them. Additionally, this class has another important role: it is responsible for deciding which strategy class to create. The specific approach involves writing the strategy classes and operation symbols in an `application.properties` file. `OperationStrategiesFactory` is responsible for reading this file and then determining which strategy class to create based on the operation symbol passed in by the client. This also reflects the **Dependency Inversion Principle**.

    Additionally, in the client `CalculatorApp`, we pass an interface of the strategy class `OperationStrategy`, rather than a specific strategy class. This way, when we adopt a different strategy class, we don't need to change the client's code.

## **How to add sin cos function in next iteration**

Next time, we almost don't need to change any code here to add the functionality of sin and cos. We just need to modify the `application.properties` file, adding the corresponding relationships between sin and cosine and the strategy classes, and then create the corresponding strategy classes for sin and cosine.

## **Other Description**

### Parser

Additionally, it's necessary to mention that the `Parser` class is responsible for parsing an expression into operands and operation. Based on the description, the input format is 'Operand Operation Operand',  so expressions like `2+3+5` would be considered invalid.&#x20;

In calculations, most can be represented in the form of 'Operand Operation Operand' or 'Operation Operand', such as `2+3` or `log5`, `cos 3`, etc. Therefore, the focus here is on parsing these two forms.

For any complex calculation, such as `1+2-3*4/5%6+sin7-cos8 + tan9 *ctg10`, we can simplify it into several `Operand Operation Operand` and `Operation Operand` structures. Therefore, the logic here can also be used to expand the functionality of computing complex expressions without any update.

Here, the expression comes from console input, so some validation has been implemented to prevent illegal input.&#x20;

### AbstractTwoOperandsOperation

This class is responsible for verifying whether the number of operand inputs for binary operations is accurate. Since the calculation method defined in `OperationStrategy` is of variable length, for binary operations, which are in the form of `Operand Operation Operand`, we need to ensure that exactly two numbers are input. Although we already have validation in the `Parser`, to make the program more robust, we perform validation again here.&#x20;

Therefore, if we want to implement the functionality of sin and cossine, we can also create an `AbstractOneOperandOperation` to verify the number of operand inputs for sin and cosine. Of course, the steps mentioned above are sufficient. `AbstractOneOperandOperation` only serves to enhance the robustness of the program.&#x20;

## **How to run it**&#x20;

run the below command to compile the whole project.&#x20;

```bash
mvn compile

```

run the below command to run the test&#x20;

```bash
mvn test

```

run the below command to run the application

```bash
mvn exec:java

```


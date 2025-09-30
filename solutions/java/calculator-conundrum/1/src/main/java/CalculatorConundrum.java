class CalculatorConundrum {
    public String calculate(int operand1, int operand2, String operation) {
        if (operation == null) {
            throw new IllegalArgumentException("Operation cannot be null");
        }
        if (operation.isEmpty()) {
            throw new IllegalArgumentException("Operation cannot be empty");
        }

        int result = 0;

        switch (operation) {
            case "/": {

                if (operand2 == 0) {
                    throw new IllegalOperationException("Division by zero is not allowed", new ArithmeticException());
                }
                result = operand1 / operand2;
                break;
            }
            case "+": {
                result = operand1 + operand2;
                break;
            }

            case "*": {
                result = operand1 * operand2;
                break;
            }

            default: {
                throw new IllegalOperationException(String.format("Operation '%s' does not exist", operation));
            }
        }

        return String.format("%s %s %s = %s", operand1, operation, operand2, result);
    }
}

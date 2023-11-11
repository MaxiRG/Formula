package edu.austral.ingsis.math

class Operation(private val function: ((List<Double>) -> Double), private val name: String, val arguments: List<Function>): Function {
    override fun getValue(variableMap: Map<String, Double>): Double {
        return function(getDoubleList(variableMap));
    }

    override fun getString(): String {
        return getStringFromList();
    }

    override fun getVariables(variables: List<String>): List<String> {
        return getVariablesFromList(variables);
    }

    private fun getDoubleList(variableMap: Map<String, Double>): List<Double> {
        var numbers = listOf<Double>();
        for (argument in arguments) {
            numbers = numbers.plus(argument.getValue(variableMap))
        }
        return numbers;
    }

    private fun getStringFromList(): String {
        val argumentsFirstLast = arguments.minus(arguments.first())
        val first = arguments.first()
        var finalString = "";
        for (argument in argumentsFirstLast) {
            finalString = when(argument) {
                is Operation -> finalString + " " + name + " " + "(" + argument.getString() + ")"
                else -> finalString + " " + name + " " + argument.getString()
            }
        }
        finalString = when(first) {
            is Operation -> "(" + first.getString() + ")" + finalString
            else -> first.getString() + finalString
        }
        return finalString;
    }

    private fun getVariablesFromList(variables: List<String>):List<String>{
        var variableList = listOf<String>();
        for (argument in arguments){
            variableList = variableList.plus(argument.getVariables(variables))
        }
        return variableList;
    }
}
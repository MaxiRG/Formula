package edu.austral.ingsis.math

class Variable(private val name:String):Function {
    override fun getValue(variableMap: Map<String, Double>): Double {
        return variableMap[name]?: throw NoSuchElementException("getValue was called on a function that has an undeclared variable: " + name)
    }

    override fun getString(): String {
        return name
    }

    override fun getVariables(variables: List<String>): List<String> {
        return variables.plus(name);
    }

}
package com.gmail.visualbukkit.blocks.statements;

import com.gmail.visualbukkit.blocks.StatementBlock;
import com.gmail.visualbukkit.blocks.annotations.Description;
import com.gmail.visualbukkit.blocks.components.ChoiceParameter;
import com.gmail.visualbukkit.plugin.BuildContext;
import com.gmail.visualbukkit.plugin.PluginModule;

import java.util.List;

@Description("Adds a value to a complex variable (the variable must be set to a number or a list)")
public class StatAddToComplexVariable extends StatementBlock {

    public StatAddToComplexVariable() {
        init("add ", Object.class, " to ", new ChoiceParameter("local", "global", "persistent"), " ", List.class);
    }

    @Override
    public void prepareBuild(BuildContext context) {
        context.addPluginModules(PluginModule.VARIABLES);
    }

    @Override
    public String toJava() {
        return "VariableManager.addToVariable(VariableType." + arg(1).toUpperCase() + "," + arg(0) + "," + arg(2) + ".toArray());";
    }
}

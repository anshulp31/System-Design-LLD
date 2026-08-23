package BehavioralDesign.TemplateMethod;


// Template Method Pattern is a behavioral design pattern that defines the skeleton of an algorithm in a method, deferring some steps to subclasses. It allows subclasses to redefine certain steps of an algorithm without changing its structure. The fixed sequence lives in one place, and varying steps are subclassed.
abstract class BuildPipeline {
    public void checkout(){
        System.out.println("Starting checkout process...");
    }

    public abstract void installDependencies();
    public abstract void compile();
    public abstract void test();

    public void deploy(){
        System.out.println("Deploying the application...");
    }

    public final void executePipeline() {
        checkout();
        installDependencies();
        compile();
        test();
        if(this.deployable()) {
            deploy();
        }
    }

    public boolean deployable(){
        return false;
    }
}

class NodeBuildPipeline extends BuildPipeline {
    @Override
    public void installDependencies() {
        System.out.println("Installing Node.js dependencies...");
    }

    @Override
    public void compile() {
        System.out.println("tsc - Compiling TypeScript files...");
    }

    @Override
    public void test() {
        System.out.println("Running Node.js tests... using Jest framework");
    }

    @Override
    public boolean deployable() {
        return true;
    }
}

class JavaBuildPipeline extends BuildPipeline {
    @Override
    public void installDependencies() {
        System.out.println("Installing Java dependencies using Maven...");
    }

    @Override
    public void compile() {
        System.out.println("mvn compile - Compiling Java files...");
    }

    @Override
    public void test() {
        System.out.println("Running Java tests... using JUnit framework");
    }
}

public class Main {
    public static void main(String[] args) {
        BuildPipeline nodePipeline = new NodeBuildPipeline();
        nodePipeline.executePipeline();

        BuildPipeline javaPipeline = new JavaBuildPipeline();
        javaPipeline.executePipeline();
    }
}

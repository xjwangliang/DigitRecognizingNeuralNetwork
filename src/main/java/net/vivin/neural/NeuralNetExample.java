package net.vivin.neural;

import net.vivin.neural.activators.ThresholdActivationStrategy;

/**
 * Created by IntelliJ IDEA.
 * User: vivin
 * Date: 11/5/11
 * Time: 4:58 PM
 */
public class NeuralNetExample {

    public static void main(String[] args) {
        NeuralNetwork andNeuralNetwork = createAndNeuralNetwork();
        NeuralNetwork orNeuralNetwork = createOrNeuralNetwork();
        NeuralNetwork xorNeuralNetwork = createXorNeuralNetwork();

        System.out.println("Testing AND neural network");

        andNeuralNetwork.setInputs(new double[]{0, 0});
        System.out.println("0 AND 0: " + andNeuralNetwork.getOutput()[0]);

        andNeuralNetwork.setInputs(new double[]{0, 1});
        System.out.println("0 AND 1: " + andNeuralNetwork.getOutput()[0]);

        andNeuralNetwork.setInputs(new double[]{1, 0});
        System.out.println("1 AND 0: " + andNeuralNetwork.getOutput()[0]);

        andNeuralNetwork.setInputs(new double[]{1, 1});
        System.out.println("1 AND 1: " + andNeuralNetwork.getOutput()[0] + "\n");


        System.out.println("Testing OR neural network");

        orNeuralNetwork.setInputs(new double[]{0, 0});
        System.out.println("0 OR 0: " + orNeuralNetwork.getOutput()[0]);

        orNeuralNetwork.setInputs(new double[]{0, 1});
        System.out.println("0 OR 1: " + orNeuralNetwork.getOutput()[0]);

        orNeuralNetwork.setInputs(new double[]{1, 0});
        System.out.println("1 OR 0: " + orNeuralNetwork.getOutput()[0]);

        orNeuralNetwork.setInputs(new double[]{1, 1});
        System.out.println("1 OR 1: " + orNeuralNetwork.getOutput()[0] + "\n");


        System.out.println("Testing XOR neural network");

        xorNeuralNetwork.setInputs(new double[]{0, 0});
        System.out.println("0 XOR 0: " + xorNeuralNetwork.getOutput()[0]);

        xorNeuralNetwork.setInputs(new double[]{0, 1});
        System.out.println("0 XOR 1: " + xorNeuralNetwork.getOutput()[0]);

        xorNeuralNetwork.setInputs(new double[]{1, 0});
        System.out.println("1 XOR 0: " + xorNeuralNetwork.getOutput()[0]);

        xorNeuralNetwork.setInputs(new double[]{1, 1});
        System.out.println("1 XOR 1: " + xorNeuralNetwork.getOutput()[0] + "\n");
    }

    private static NeuralNetwork createAndNeuralNetwork() {
        NeuralNetwork andNeuralNetwork = new NeuralNetwork();

        Layer inputLayer = new Layer(null);

        Neuron a = new Neuron(new ThresholdActivationStrategy(1));
        Neuron b = new Neuron(new ThresholdActivationStrategy(1));

        inputLayer.addNeuron(a);
        inputLayer.addNeuron(b);

        Layer outputLayer = new Layer(inputLayer);
        Neuron andNeuron = new Neuron(new ThresholdActivationStrategy(1.5));
        outputLayer.addNeuron(andNeuron, new double[]{1, 1});

        andNeuralNetwork.addLayer(inputLayer);
        andNeuralNetwork.addLayer(outputLayer);

        return andNeuralNetwork;
    }

    private static NeuralNetwork createOrNeuralNetwork() {
        NeuralNetwork orNeuralNetwork = new NeuralNetwork();

        Layer inputLayer = new Layer(null);

        Neuron a = new Neuron(new ThresholdActivationStrategy(1));
        a.setOutput(0);

        Neuron b = new Neuron(new ThresholdActivationStrategy(1));
        b.setOutput(0);

        inputLayer.addNeuron(a);
        inputLayer.addNeuron(b);

        Layer outputLayer = new Layer(inputLayer);
        Neuron orNeuron = new Neuron(new ThresholdActivationStrategy(0.9));
        outputLayer.addNeuron(orNeuron, new double[]{1, 1});

        orNeuralNetwork.addLayer(inputLayer);
        orNeuralNetwork.addLayer(outputLayer);

        return orNeuralNetwork;
    }

    private static NeuralNetwork createXorNeuralNetwork() {
        NeuralNetwork xorNeuralNetwork = new NeuralNetwork();

        Layer inputLayer = new Layer(null);

        Neuron a = new Neuron(new ThresholdActivationStrategy(1));
        a.setOutput(0);

        Neuron b = new Neuron(new ThresholdActivationStrategy(1));
        b.setOutput(0);

        inputLayer.addNeuron(a);
        inputLayer.addNeuron(b);

        Layer hiddenLayer = new Layer(inputLayer);

        Neuron hiddenA = new Neuron(new ThresholdActivationStrategy(1.5));
        Neuron hiddenB = new Neuron(new ThresholdActivationStrategy(0.5));

        hiddenLayer.addNeuron(hiddenA, new double[]{1, 1});
        hiddenLayer.addNeuron(hiddenB, new double[]{1, 1});

        Layer outputLayer = new Layer(hiddenLayer);
        Neuron xorNeuron = new Neuron(new ThresholdActivationStrategy(0.5));
        outputLayer.addNeuron(xorNeuron, new double[]{-1, 1});

        xorNeuralNetwork.addLayer(inputLayer);
        xorNeuralNetwork.addLayer(hiddenLayer);
        xorNeuralNetwork.addLayer(outputLayer);

        return xorNeuralNetwork;
    }
}

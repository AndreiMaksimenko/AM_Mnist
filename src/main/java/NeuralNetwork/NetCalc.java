package NeuralNetwork;

final class NetCalc {

  static double Sigmoid(double signal){
    double sigmoid = 1/( 1 + Math.pow(Math.E,(-1*signal)));
    return sigmoid;
  }

  static double EndNeuronError(double label, double sigmoid){
    double error = label - sigmoid;
    return error;
  }

  static double NeuronError(double weightOld, double deltaWeight){
    double error = weightOld*deltaWeight;
    return error;
  }

  static double NewWeight(double error, double inputSigmoid, double sigmoid, double learningRate, double oldWeight){
    double newWeight = oldWeight + (learningRate*error*sigmoid*(1-sigmoid)*inputSigmoid); // Wnew = Wold + Lr*Er*dS/dx*Sigm
    return newWeight;
  }



}

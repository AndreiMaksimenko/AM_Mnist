package NeuralNetwork;

final class NetCalc {

  static double Sigmoid(double signal) {
    return 1 / (1 + Math.pow(Math.E, (-1 * signal)));
  }

  static double EndNeuronError(double label, double sigmoid) {
    double error = (label - sigmoid) * (1 - sigmoid) * sigmoid; // (Разница выхода сигмоида и ожидаемоего решения) с поправкой на производную сигмоида
    return error;
  }

  static double HiddenNeuronError(double[] nextLayerErrors, double[] weights, double signal) {
    double error = 0;
    for (int i = 0; i < weights.length; i++) {
      error += weights[i] * nextLayerErrors[i];
    }
    return error * (1 - signal) * signal;  // (Сумма всех ошибок следующего нейрона * связанные с ними веса) с поправкой на производную сигмоида
  }

  static double[][] NewWeights(double[][] weights, double[] errors, double[] signals, double learningRate) {
//    double[][] newWeight = oldWeight + (learningRate*error* Outputsigmoid *(1- Outputsigmoid)*inputSigmoid); // Wnew = Wold + Lr*Er*dS/dx*Sigm

    double[][] newWeights = new double[weights.length][weights[0].length];
    for (int i = 0; i < weights.length; i++) {
      for (int j = 0; j < weights[i].length; j++) {
        newWeights[i][j] = weights[i][j] + (learningRate*signals[i]*errors[j]);
      }
    }

    return newWeights;
  }


}

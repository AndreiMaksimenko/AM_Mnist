package NeuralNetwork;

public class NeuralLayer {
    private double[] inputSignals; //Входящие сигналы по поличеству нейронов на предыдущем слое
    private double[][] weights; //Веса на все входящие ребра
    private int neurons; // количество нейронов этого слоя

//  private double[] layerErrors;
//  private double[] outputSignals;
//  private double[] errorsToBackLayer;

  public double[] GetOutputSignals()
  {
    double [] outputSignals = new double[neurons];
    for(int i = 0; i<=neurons; i++){
      double summOfSignalsToNeuron=0;
      for (int j = 0; j<=neurons; j++){
        summOfSignalsToNeuron += inputSignals[j]*weights[i][j];  // Сумма входяхих сигналов умноженная на их вес
      }
      outputSignals[i] = NetCalc.Sigmoid(summOfSignalsToNeuron); // Сигмоид от суммы входящих сигналов умноженных на вес
    }
    return outputSignals;
  }

  public double[] GetPropogationErrors() {
  }

  public double[] GetLayerErrors() {
  }

  public void ChangeWeights(){

  }



}

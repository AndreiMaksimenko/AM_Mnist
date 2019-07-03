package NeuralNetwork;

public class InputLayer {
  private double[] signals;
  private double[] outputSignals;

  public InputLayer(double[] signals) {
    this.signals = signals;
    MakeOutputs();
  }

  private void MakeOutputs(){

    for(int i = 0; i<=signals.length; i++){
      this.outputSignals[i]=signals[i]/256;
    }
  }

  public double[] getOutputSignals() {
    return this.outputSignals;
  }
}

package NeuralNetwork;

interface NNLayer {
  double[] GetPropagationErrors();
  double[] GetOutputSignals();
  int GetLength();
  void setForwardLayer(NNLayer forwardLayer);
  void setSignals(double[] signals);
}

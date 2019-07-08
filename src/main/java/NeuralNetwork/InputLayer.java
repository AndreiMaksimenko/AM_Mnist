package NeuralNetwork;


class InputLayer implements NNLayer {


  private double[] outputSignals;
  // private NNLayer forwardLayer;


  /**
   * Конструктор, задаст длину 784
   * чтобы при создании всей сети вышла правильная архитектура
   **/

  InputLayer() {
    this.outputSignals = new double[784];
  }




  /**
   * Задем входящие сигналы для анализа
   * и нормализуем их (от 0 до 1)
   **/

  @Override
  public void setSignals(double[] signals) {
    this.outputSignals = signals;
    for(int i = 0; i<outputSignals.length; i++){
      this.outputSignals[i]=outputSignals[i]/256;
    }
  }


  /**
   * Возвращает выходной сигнал после получения входного сигнала и его нормализации
   * Выходной сигнал используется следующим слоем
   **/

  @Override
  public double[] GetOutputSignals()
  {
    return this.outputSignals;
  }


  /**
   * Возвращает количество нейронов в слое
   * для данного слоя - это количество входных сигналов (или пискселей)
   **/

  @Override
  public int GetLength() {
    return outputSignals.length;
  }



  /* ХЛАААМ!!!*/


  /**
   * Артефактный метод
   * разберись и  удали !!!
   **/

  @Override
  public void setForwardLayer(NNLayer forwardLayer) {

  }



  /**
   * Артефактный метод
   * разберись и  удали !!!
   **/

  @Override
  public double[] GetPropagationErrors()
  {
    return null;
  }

}

package NeuralNetwork;


class InputLayer implements NNLayer {
  private double[] outputSignals;


  /**
   * Конструктор по умолчанию, задаст длину 784
   * чтобы при создании всей сети вышла правильная архитектура
   **/

  InputLayer() {
    this.outputSignals = new double[784];
  }

  /**
   * Конструктор не по умолчанию, с установленно длинной входящего сигнала
   * чтобы при создании всей сети вышла правильная архитектура
   **/
  InputLayer(int size){
    this.outputSignals = new double[size];
  }




  /**
   * Задем входящие сигналы для анализа
   * и нормализуем их (от 0 до 1)
   **/

  @Override
  public void setSignals(double[] signals) {
//    this.outputSignals = signals;
    for(int i = 0; i<outputSignals.length; i++){
      outputSignals[i]=signals[i]/256;
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
  public double[] GetErrorsForBackLayer() {

    return null;
  }

}

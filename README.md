# kafka-resilience
`Examples of Kafka Producers and Consumers`


# Producer Configs

Por padrão, os produtores do Kafka tentam enviar os discos o mais rápido possível. Um produtor terá até 5 solicitações em andamento (controladas pelo ``max.in.flight.requests.per.connection`` setting), o que significa que até 5 lotes de mensagens serão enviados ao mesmo tempo. Depois disso, se mais mensagens precisarem ser enviadas enquanto outras estiverem em andamento, os produtores Kafka serão espertos e começarão a agrupar mensagens enquanto as solicitações de mensagens anteriores terminam.

Esse lote inteligente permite que o Kafka aumente o rendimento enquanto mantém uma latência muito baixa. Os lotes têm uma taxa de compactação mais alta, proporcionando melhor eficiência de disco e rede. O lote é controlado principalmente por duas configurações de produtor - ``linger.ms`` and ``batch.size``.

**``linger.ms``**: is the number of milliseconds a producer is willing to wait before sending a batch out. The default value is 0, which means "send the messages right away"
![img.png{ width=400px }](img.png)

**``batch.size``**: é o número máximo de bytes que serão incluídos em um lote.
O padrão é 16KB. Aumentar o tamanho do lote para 32KBou 64KBpode ajudar a aumentar a compactação, o rendimento e a eficiência das solicitações. Qualquer mensagem maior que o tamanho do lote não será agrupada. Um lote é alocado por partição, portanto, certifique-se de não configurá-lo para um número muito alto, caso contrário, você poderá usar muito memória!

>###**Principais conclusões**
>* Aumente ``linger.ms`` e o produtor esperará alguns milissegundos para que os lotes sejam preenchidos antes de enviá-los.
>* Se você estiver enviando lotes completos e tiver memória sobrando, poderá aumentar ``batch.size`` e enviar lotes maiores.

**``retries``**:  
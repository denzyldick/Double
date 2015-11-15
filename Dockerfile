FROM hseeberger/scala-sbt
RUN mkdir double
COPY / /double
WORKDIR /double
RUN sbt run
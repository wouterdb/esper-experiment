esper-experiment
================

experiment with esper in the context of monitoring

build using maven (run mvn in root)

EsperTest hooks up esper to an amqp and runs some patterns (see src/main/resources/rules.epl")
EsperTest pushes in dummy data
EsperDump prints the results

Also contains a test with websockets to output amqp data to browser

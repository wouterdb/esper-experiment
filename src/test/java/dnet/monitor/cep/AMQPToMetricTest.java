package dnet.monitor.cep;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import dnet.monitor.cep.model.CollectdMetric;

public class AMQPToMetricTest {

	@Test
	public void test() {
		String line = "PUTVAL mon/load/load interval=10.000 1350486379.728:0.040000:0.200000:0.180000";
		
		CollectdMetric m =  new AMQPCollectdToMetric().parseLine(line);
		
		assertEquals(m.getHost(), "mon");
		assertEquals(m.getPlugin(), "load");
		assertEquals(m.getType(), "load");
		assertEquals(m.getOpts(), "interval=10.000");
		assertEquals(m.getTime(), new Date(1350486379728L));
		assertArrayEquals(m.getValues(), new float[]{0.040000f,0.200000f,0.180000f},0);
	}

}

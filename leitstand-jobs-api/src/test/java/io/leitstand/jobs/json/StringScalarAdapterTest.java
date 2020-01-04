/*
 * (c) RtBrick, Inc - All rights reserved, 2015 - 2019
 */
package io.leitstand.jobs.json;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Collection;
import java.util.UUID;

import javax.json.bind.adapter.JsonbAdapter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import io.leitstand.commons.model.Scalar;
import io.leitstand.jobs.jsonb.JobIdAdapter;
import io.leitstand.jobs.jsonb.TaskIdAdapter;
import io.leitstand.jobs.service.JobId;
import io.leitstand.jobs.service.TaskId;

@RunWith(Parameterized.class)
public class StringScalarAdapterTest {

	@Parameters
	public static Collection<Object[]> adapters(){
		String uuid = UUID.randomUUID().toString();
		Object[][] adapters = new Object[][]{
			{new JobIdAdapter(),  	uuid,		 					new JobId(uuid)},
			{new TaskIdAdapter(),	 			uuid,				new TaskId(uuid)},
		};
		return asList(adapters);
	}
	
	
	private JsonbAdapter<Scalar<String>,String> adapter;
	private Scalar<String> scalar;
	private String string;
	
	public StringScalarAdapterTest(JsonbAdapter<Scalar<String>,String> adapter,
								  String string,
								  Scalar<String> scalar) {
		this.adapter = adapter;
		this.string = string;
		this.scalar = scalar;
		
	}
	
	@Test
	public void empty_string_is_mapped_to_null() throws Exception {
		assertNull(adapter.adaptFromJson(""));
	}
	
	@Test
	public void null_string_is_mapped_to_null() throws Exception {
		assertNull(adapter.adaptFromJson(null));
	}
	
	@Test
	public void valid_string_is_adaptFromJsonled_properly() throws Exception{
		assertEquals(scalar,adapter.adaptFromJson(string));
	}
	
	@Test
	public void non_null_scalar_is_marshalled_properly() throws Exception {
		assertEquals(string,adapter.adaptToJson(scalar));
	}
	
	@Test
	public void null_scalar_is_mapped_to_null() throws Exception{
		assertNull(adapter.adaptToJson(null));
	}
	
}

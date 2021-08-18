package com.github.silviorss;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.github.database.rider.cdi.api.DBRider;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.silviorss.entity.Produto;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;

@DBRider
@QuarkusTest
@QuarkusTestResource(DatabaseLifecycle.class)
public class ProdutoTest {

	@Test
	@DataSet("produtos1.yml")
	public void sizeProdutoTest() {
		Assert.assertEquals(1, Produto.count());
	}
}

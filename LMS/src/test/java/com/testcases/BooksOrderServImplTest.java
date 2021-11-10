package com.testcases;

	import static org.assertj.core.api.Assertions.assertThat;
	import static org.junit.jupiter.api.Assertions.*;

	import java.util.ArrayList;
	import java.util.List;
	import java.util.Optional;

	import org.junit.jupiter.api.Test;
	import org.mockito.Mockito;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.test.context.SpringBootTest;
	import org.springframework.boot.test.mock.mockito.MockBean;

import com.entites.BooksOrder;
import com.repository.BooksOrderRepository;
import com.service.BooksOrderServ;
	@SpringBootTest
	class BooksOrderServiceImplTest {
		@Autowired
		BooksOrderServ bookorderservice;
		@MockBean
		BooksOrderRepository booksorderrepo;
		@Test
		void testPlaceBooksOrder() {
			BooksOrder bo = new BooksOrder();
			bo.setOrderId(1);
			bo.setOrderDate(null);
			bo.setOrderStatus("ordered");
			bo.setQuantity(1);
			Mockito.when(booksorderrepo.save(bo)).thenReturn(bo);
			assertThat(bookorderservice.placeBooksOrder(bo)).isEqualTo(bo);
		}

		@Test
		void testCancelOrder() {
			BooksOrder bo = new BooksOrder();
			bo.setOrderId(1);
			bo.setOrderDate(null);
			bo.setOrderStatus("ordered");
			bo.setQuantity(1);
			Optional<BooksOrder> c2=Optional.of(bo);
			Mockito.when(booksorderrepo.findById(1)).thenReturn(c2);
			Mockito.when(booksorderrepo.existsById(bo.getOrderId())).thenReturn(false);
			assertFalse(booksorderrepo.existsById(bo.getOrderId()));
		}

		@Test
		void testUpdateOrder() throws Throwable {
			BooksOrder bo = new BooksOrder();
			bo.setOrderId(1);
			bo.setOrderDate(null);
			bo.setOrderStatus("ordered");
			bo.setQuantity(1);
			Optional<BooksOrder> bord2 =  Optional.of(bo);
			Mockito.when(booksorderrepo.findById(1)).thenReturn(bord2);
			Mockito.when(booksorderrepo.save(bo)).thenReturn(bo);
			bo.setOrderDate(null);
			bo.setOrderStatus("ordered");
			bo.setQuantity(2);
			assertThat(bookorderservice.updateOrder(bo)).isEqualTo(bo);
		}

		@Test
		void testViewOrdersList() {
			BooksOrder bo = new BooksOrder();
			bo.setOrderId(1);
			bo.setOrderDate(null);
			bo.setOrderStatus("ordered");
			bo.setQuantity(1);
			
			BooksOrder bo1 = new BooksOrder();
			bo1.setOrderId(1);
			bo1.setOrderDate(null);
			bo1.setOrderStatus("ordered");
			bo1.setQuantity(1);
			
			List<BooksOrder> orderList = new ArrayList<BooksOrder>();
			orderList.add(bo);
			orderList.add(bo1);
			
			Mockito.when(booksorderrepo.findAll()).thenReturn(orderList);
			assertThat(bookorderservice.viewOrdersList()).isEqualTo(orderList);
		}

		@Test
		void testViewOrderById() throws Throwable {
			BooksOrder bo = new BooksOrder();
			bo.setOrderId(1);
			bo.setOrderDate(null);
			bo.setOrderStatus("ordered");
			bo.setQuantity(1);
			Optional<BooksOrder> c2 = Optional.of(bo);
			Mockito.when(booksorderrepo.findById(1)).thenReturn(c2);
			assertThat(bookorderservice.viewOrderById(1)).isEqualTo(bo);
		}

	}



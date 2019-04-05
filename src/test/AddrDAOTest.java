package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import dao.AddrDAO;
import dao.impl.AddrDAOImpl;

public class AddrDAOTest {
	AddrDAO adao = new AddrDAOImpl();
	
	@Test
	public void test1() {
		Map<String,String> addr = new HashMap<>();
		addr.put("sNum", "1");
		addr.put("lNum", "30");
		List<Map<String,String>> addrList = adao.selectAddrList(addr);
		assertEquals(30, addrList.size());
	}
//	@Test
	public void addrCountTest() {
		//int totalCnt = adao.selectTotalAddrCnt();
		//assertEquals(358425, totalCnt);
	}
}

package cloud.pangeacyber.pangea.intel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import cloud.pangeacyber.pangea.Config;
import cloud.pangeacyber.pangea.TestEnvironment;
import cloud.pangeacyber.pangea.exceptions.ConfigException;
import cloud.pangeacyber.pangea.exceptions.PangeaAPIException;
import cloud.pangeacyber.pangea.exceptions.PangeaException;
import cloud.pangeacyber.pangea.exceptions.UnauthorizedException;
import cloud.pangeacyber.pangea.exceptions.ValidationException;
import cloud.pangeacyber.pangea.intel.models.IPReputationResponse;
import cloud.pangeacyber.pangea.intel.models.IntelLookupData;
import cloud.pangeacyber.pangea.intel.models.IntelReputationData;
import cloud.pangeacyber.pangea.intel.models.IpLookupResponse;
import org.junit.Before;
import org.junit.Test;

public class ITIPIntelTest {

	IpIntelClient client;
	TestEnvironment environment = TestEnvironment.LIVE;

	@Before
	public void setUp() throws ConfigException {
		client = new IpIntelClient(Config.fromIntegrationEnvironment(environment));
		client.setCustomUserAgent("test");
	}

	@Test
	public void testIpLookupMalicious_1() throws PangeaException, PangeaAPIException {
		// Default provider, not verbose by default, not raw by default;
		IpLookupResponse response = client.lookup("93.231.182.110");
		assertTrue(response.isOk());

		IntelLookupData data = response.getResult().getData();
		assertEquals("malicious", data.getVerdict());
		assertNull(response.getResult().getParameters());
		assertNull(response.getResult().getRawData());
	}

	@Test
	public void testIpLookupMalicious_2() throws PangeaException, PangeaAPIException {
		// With provider, not verbose by default, not raw by default;
		IpLookupResponse response = client.lookup("93.231.182.110", "crowdstrike");
		assertTrue(response.isOk());

		IntelLookupData data = response.getResult().getData();
		assertEquals("malicious", data.getVerdict());
		assertNull(response.getResult().getParameters());
		assertNull(response.getResult().getRawData());
	}

	@Test
	public void testIpLookupMalicious_3() throws PangeaException, PangeaAPIException {
		// Default provider, no verbose, no raw;
		IpLookupResponse response = client.lookup("93.231.182.110", false, false);
		assertTrue(response.isOk());

		IntelLookupData data = response.getResult().getData();
		assertEquals("malicious", data.getVerdict());
		assertNull(response.getResult().getParameters());
		assertNull(response.getResult().getRawData());
	}

	@Test
	public void testIpLookupMalicious_4() throws PangeaException, PangeaAPIException {
		// Default provider, verbose, no raw;
		IpLookupResponse response = client.lookup("93.231.182.110", true, false);
		assertTrue(response.isOk());

		IntelLookupData data = response.getResult().getData();
		assertEquals("malicious", data.getVerdict());
		assertNotNull(response.getResult().getParameters());
		assertNull(response.getResult().getRawData());
	}

	@Test
	public void testIpLookupMalicious_5() throws PangeaException, PangeaAPIException {
		// Default provider, no verbose, raw;
		IpLookupResponse response = client.lookup("93.231.182.110", false, true);
		assertTrue(response.isOk());

		IntelLookupData data = response.getResult().getData();
		assertEquals("malicious", data.getVerdict());
		assertNull(response.getResult().getParameters());
		assertNotNull(response.getResult().getRawData());
	}

	@Test
	public void testIpLookupMalicious_6() throws PangeaException, PangeaAPIException {
		// Default provider, verbose, raw;
		IpLookupResponse response = client.lookup("93.231.182.110", true, true);
		assertTrue(response.isOk());

		IntelLookupData data = response.getResult().getData();
		assertEquals("malicious", data.getVerdict());
		assertNotNull(response.getResult().getParameters());
		assertNotNull(response.getResult().getRawData());
	}

	@Test
	public void testIpLookupMalicious_7() throws PangeaException, PangeaAPIException {
		// Provider, no verbose, no raw
		IpLookupResponse response = client.lookup("93.231.182.110", "crowdstrike", false, false);
		assertTrue(response.isOk());

		IntelLookupData data = response.getResult().getData();
		assertEquals("malicious", data.getVerdict());
		assertNull(response.getResult().getParameters());
		assertNull(response.getResult().getRawData());
	}

	@Test
	public void testIpLookupMalicious_8() throws PangeaException, PangeaAPIException {
		// Provider, verbose, raw
		IpLookupResponse response = client.lookup("93.231.182.110", "crowdstrike", true, true);
		assertTrue(response.isOk());

		IntelLookupData data = response.getResult().getData();
		assertEquals("malicious", data.getVerdict());
		assertNotNull(response.getResult().getParameters());
		assertNotNull(response.getResult().getRawData());
	}

	@Test
	public void testIpReputationMalicious_1() throws PangeaException, PangeaAPIException {
		// Default provider, not verbose by default, not raw by default;
		IPReputationResponse response = client.reputation("93.231.182.110");
		assertTrue(response.isOk());

		IntelReputationData data = response.getResult().getData();
		assertEquals("malicious", data.getVerdict());
		assertNull(response.getResult().getParameters());
		assertNull(response.getResult().getRawData());
	}

	@Test
	public void testIpReputationMalicious_2() throws PangeaException, PangeaAPIException {
		// With provider, not verbose by default, not raw by default;
		IPReputationResponse response = client.reputation("93.231.182.110", "crowdstrike");
		assertTrue(response.isOk());

		IntelReputationData data = response.getResult().getData();
		assertEquals("malicious", data.getVerdict());
		assertNull(response.getResult().getParameters());
		assertNull(response.getResult().getRawData());
	}

	@Test
	public void testIpReputationMalicious_3() throws PangeaException, PangeaAPIException {
		// Default provider, no verbose, no raw;
		IPReputationResponse response = client.reputation("93.231.182.110", false, false);
		assertTrue(response.isOk());

		IntelReputationData data = response.getResult().getData();
		assertEquals("malicious", data.getVerdict());
		assertNull(response.getResult().getParameters());
		assertNull(response.getResult().getRawData());
	}

	@Test
	public void testIpReputationMalicious_4() throws PangeaException, PangeaAPIException {
		// Default provider, verbose, no raw;
		IPReputationResponse response = client.reputation("93.231.182.110", true, false);
		assertTrue(response.isOk());

		IntelReputationData data = response.getResult().getData();
		assertEquals("malicious", data.getVerdict());
		assertNotNull(response.getResult().getParameters());
		assertNull(response.getResult().getRawData());
	}

	@Test
	public void testIpReputationMalicious_5() throws PangeaException, PangeaAPIException {
		// Default provider, no verbose, raw;
		IPReputationResponse response = client.reputation("93.231.182.110", false, true);
		assertTrue(response.isOk());

		IntelReputationData data = response.getResult().getData();
		assertEquals("malicious", data.getVerdict());
		assertNull(response.getResult().getParameters());
		assertNotNull(response.getResult().getRawData());
	}

	@Test
	public void testIpReputationMalicious_6() throws PangeaException, PangeaAPIException {
		// Default provider, verbose, raw;
		IPReputationResponse response = client.reputation("93.231.182.110", true, true);
		assertTrue(response.isOk());

		IntelReputationData data = response.getResult().getData();
		assertEquals("malicious", data.getVerdict());
		assertNotNull(response.getResult().getParameters());
		assertNotNull(response.getResult().getRawData());
	}

	@Test
	public void testIpReputationMalicious_7() throws PangeaException, PangeaAPIException {
		// Provider, no verbose, no raw
		IPReputationResponse response = client.reputation("93.231.182.110", "crowdstrike", false, false);
		assertTrue(response.isOk());

		IntelReputationData data = response.getResult().getData();
		assertEquals("malicious", data.getVerdict());
		assertNull(response.getResult().getParameters());
		assertNull(response.getResult().getRawData());
	}

	@Test
	public void testIpReputationMalicious_8() throws PangeaException, PangeaAPIException {
		// Provider, verbose, raw
		IPReputationResponse response = client.reputation("93.231.182.110", "crowdstrike", true, true);
		assertTrue(response.isOk());

		IntelReputationData data = response.getResult().getData();
		assertEquals("malicious", data.getVerdict());
		assertNotNull(response.getResult().getParameters());
		assertNotNull(response.getResult().getRawData());
	}

	@Test(expected = ValidationException.class)
	public void testEmptyIP() throws PangeaException, PangeaAPIException {
		IPReputationResponse response = client.reputation("", "crowdstrike", true, true);
	}

	@Test(expected = ValidationException.class)
	public void testEmptyProvider() throws PangeaException, PangeaAPIException {
		IPReputationResponse response = client.reputation("93.231.182.110", "", true, true);
	}

	@Test(expected = ValidationException.class)
	public void testEmptyNotValidProvider() throws PangeaException, PangeaAPIException {
		IPReputationResponse response = client.reputation("93.231.182.110", "notvalidprovider", true, true);
	}

	@Test(expected = UnauthorizedException.class)
	public void testUnauthorized() throws PangeaException, PangeaAPIException, ConfigException {
		Config cfg = Config.fromIntegrationEnvironment(environment);
		cfg.setToken("notarealtoken");
		IpIntelClient fakeClient = new IpIntelClient(cfg);
		IPReputationResponse response = fakeClient.reputation("93.231.182.110");
	}
}

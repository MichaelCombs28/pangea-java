package cloud.pangeacyber.pangea.vault.results;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CommonGenerateResult {

	@JsonProperty("type")
	String type;

	@JsonInclude(Include.NON_NULL)
	@JsonProperty("id")
	String id = null;

	@JsonInclude(Include.NON_NULL)
	@JsonProperty("version")
	Integer version = null;

	public CommonGenerateResult() {}

	public CommonGenerateResult(String type, String id, Integer version) {
		this.type = type;
		this.id = id;
		this.version = version;
	}

	public String getType() {
		return type;
	}

	public String getId() {
		return id;
	}

	public Integer getVersion() {
		return version;
	}
}

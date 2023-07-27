package com.momo.customer.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor
public class Histories {
	private History h1 = new History(1, "s1", "o1", 0, 0);
	private History h2 = new History(2, "s2", "o2", 1, 0);
	private History h3 = new History(3, "s3", "o3", 0, 0);
}

package com.sh.pj.care;

import java.util.List;

public interface CareMapper {

	List<CareDTO> getAll(CareDTO cDTO);

	CareDTO detail(CareDTO cDTO);

}

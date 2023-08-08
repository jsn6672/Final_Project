package com.sh.pj.ask;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface AskMapper {

	public List<AskDTO> getAllAsk();

	public int insertask(AskDTO aDTO);

	public AskDTO getaskno(AskDTO aDTO);

	public int deleteask(AskDTO aDTO);

	public int upadteask(AskDTO aDTO);

	public List<AskDTO> searchask(AskDTO aDTO);

	public int getMsgCount(AskSelector search);


}

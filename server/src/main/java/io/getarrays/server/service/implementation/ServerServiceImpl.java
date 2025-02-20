package io.getarrays.server.service.implementation;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collection;

import org.springframework.stereotype.Service;

import io.getarrays.server.enumeration.Status;
import io.getarrays.server.model.Server;
import io.getarrays.server.repo.ServerRepo;
import io.getarrays.server.service.ServerService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class ServerServiceImpl implements ServerService {
	
	private final ServerRepo serverRepo = null;

	@Override
	public Server create(Server server) {
		log.info("Saving new server: {}", server.getName());
		server.setImageUrl(setServerImageUrl());
		return serverRepo.save(server);
	}

	private String setServerImageUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Server> list(int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Server get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Server update(Server server) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Server ping(String ipAddress) throws IOException {
		log.info("Pinging server IP: {}", ipAddress);
		Server server = serverRepo.findByIpAddress(ipAddress);
		InetAddress address = InetAddress.getByName(ipAddress);
		server.setStatus(address.isReachable(10000) ? Status.SERVER_UP : Status.SERVER_DOWN);
		serverRepo.save(server);
		return server;
	}

}

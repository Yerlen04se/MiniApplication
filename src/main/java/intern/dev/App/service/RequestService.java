package intern.dev.App.service;

import intern.dev.App.entity.Request;

import java.util.List;

public interface RequestService {

    List<Request> getAllRequests();

    Request save(Request request);

}

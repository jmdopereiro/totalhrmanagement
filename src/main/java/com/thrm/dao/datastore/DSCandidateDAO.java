package com.thrm.dao.datastore;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.thrm.domain.Candidato;

public class DSCandidateDAO {

    private DatastoreService dataStore;
    private static final String CANDIDATE_KIND = "Candidate";

    public DSCandidateDAO() {
        this.dataStore = DatastoreServiceFactory.getDatastoreService();
    }

    public Long createCandidate(Candidato candidato) {
        Entity incCandidateEntity = new Entity(CANDIDATE_KIND);
        incCandidateEntity.setProperty("nombre", candidato.getNombre());
        Key candidateKey = dataStore.put(incCandidateEntity);
        return candidateKey.getId();
    }
}

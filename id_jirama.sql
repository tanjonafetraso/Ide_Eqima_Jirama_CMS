------les vues sont créer a partir des données des tables donc on peut effacer et re-créer 
------il n'y a pas de risque de perdre des données 
------1) Effacer la vue "pass" ,vue permettant d'obtenir automatiquement les données des identifications
drop view pass 
-----2) re-créer la vue en copiant la requete suivante :  
create or replace view pass as (select authentifications.id as id_auth,current_timestamp() as datetime,authentifications.utilisateur_id,authentifications.adresse_id,
responsable_ajout.id ,responsable_ajout.id_empreintes ,responsable_ajout.score
from authentifications,responsable_ajout  
where authentifications.id=responsable_ajout.id_authentifications 
);

------la vue suivante est aussi utile pour collecter les données dont nous avons besoin dans identification
----supprimer
drop view passToIdentification;
----remplacer 
create or replace view passToIdentification as (select pass.id,pass.id_auth,pass.datetime,pass.utilisateur_id,
pass.adresse_id,pass.id_empreintes,pass.score,empreintes.doigt,empreintes.collaborateur_id 
 from pass,empreintes where pass.id_empreintes = empreintes.id );
-----(en cas de problème de liaison ---supprimer la vue identification )

-----voir les données dans identifications (dans la base test ,il n'y pas beaucoup de données mtn)
desc identification ----pour voir les colonnes dans la vue identification

----en cas de probleme avec la vue identification effacer et recreer
drop view identification

create or replace view identification as(select passToIdentification.*,utilisateurs.nom_d_utilisateur,utilisateurs.code_Cms,adresses.adresse_mac,collaborateurs.matricule
   from passToIdentification,utilisateurs,adresses,collaborateurs 
where passToIdentification.utilisateur_id=utilisateurs.id and passToIdentification.adresse_id=adresses.id
  and passToIdentification.collaborateur_id=collaborateurs.id);


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:baseProjectLayout>
	<jsp:attribute name="css">
         <link type="text/css" rel="stylesheet"
			href="<c:url value=""/>" />
    </jsp:attribute>

<jsp:attribute name="content">

<div class="container" style="width: 70%;">

            <h1>Characters</h1>
            <div class="Buttons">
                <button class="btn btn-primary" type="button"
					id="addButton" data-toggle="modal"
					data-target="#charactersAddModal">Character Aanmaken
                </button>
            </div>
            			
           <!-- Modal for adding an  Character -->
            <div class="modal fade" id="charactersAddModal"
				tabindex="-1" role="dialog"
				aria-labelledby="AddModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title"
								id="AddModalLabel">Character Aanmaken </h5>
                            <button type="button" class="close"
								data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                          <div class="modal-body">
                            <form class="characterForm"
								action="AddCharacter" role="form">
                          
                                    
                                <div class="form-group">
                                   <label for="CharacterName-input"
										class="col-2 col-form-label">Naam</label>
                                    <div class="col-10">
                                        <input class="form-control"
											name="CharacterName" type="text" value=""
											id="CharacterName-input">
                                    </div>
                                 <label
										for="Character-input"
										class="col-2 col-form-label">Selecteer EducationTeam</label>
                                	<div class="col-10">
                       

	                              <s:select theme="simple" class="form-control" listkey="abbreviation" name="abbreviation" list="Character"></s:select>

                                    </div>
                                </div>
                                      <div class="modal-footer">
                            <button type="button"
										class="btn btn-secondary" data-dismiss="modal">Annuleren</button>
                            <button type="submit"
										class="btn btn-primary">Toevoegen</button>
                        </div>
                            </form>
                        </div>
                  
                    </div>
                </div>
            </div>
            
            <!-- Modal for deleting an characters group -->
            <div class="modal fade" id="DeleteModal"
				tabindex="-1" role="dialog"
				aria-labelledby="DeleteModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title"
								id="DeleteModalLabel">Les groep verwijderen</h5>
                            <button type="button" class="close"
								data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                        
                            <p>Weet je zeker dat je de les groep ICO41A wilt verwijderen met 123 studenten?</p>
                        </div>
                        <div class="modal-footer">
                        
                         <form class="DeleteForm"
								action="deleteCharacter" role="form">
                            <button type="button"
									class="btn btn-secondary" data-dismiss="modal">Annuleren</button>
                            <button type="submit"
									value="Animal.firstName" class="btn btn-danger">Verwijderen</button>
                            </form>
                            
                        </div>
                    </div>
                </div>
            </div>	
            
         
            <table class="table Character-table table-responsive">
                <thead>
                    <tr>
                        <th>Naam</th>
                        
                        <th style="width: 100px;">Education Team</th>
                    </tr>

                </thead>
                <tbody>
						<s:iterator value="" >
                                   <tr>

                       <td><s:property value="" /></td>
 					   <td><s:property value="" /></td> 

      <td><a
								href="deleteCharacter=<s:property value=""></s:property>"
								onclick="if(confirm('Weet u zeker dat u deze wilt verwijderen?')){return true}else{return false}"><span
									class="fa fa-trash"></span></a></td>
									</tr>
                  	</s:iterator>
           
                </tbody>
          
            </table>
        </div>



</jsp:attribute>



</t:baseProjectLayout>
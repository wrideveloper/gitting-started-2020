/// <reference types="cypress" />

describe('Form input', () => {
    
    sit('visit form', () => {
        cy.visit('/')
        cy.contains('Forms').click()
        cy.contains('Form Layouts').click()
    });

    it('Fill Inline form', () => {
        cy.get('input[placeholder="Jane Doe"]').type('Denny Nur Ramadhan')
        cy.get('[placeholder="Email"][type="text"]').type('denny.dand@outlook.com')
        cy.get('.custom-checkbox').eq(0).click();
    });

    it('Fill Using the Grid', () => {
        cy.get('#inputEmail1').type('denny.dand@outlook.com')
        cy.get('#inputPassword2').type('Killer_queen666')
        cy.get('.text').contains('Option 1').click()
        cy.get('.text').contains('Option 2').click()
    });

    it('Fill Basic form', () => {
      cy.get('#exampleInputEmail1').type('denny.dand@outlook.com')
      cy.get('#exampleInputPassword1').type('Killer_queen666')
      cy.get('.custom-checkbox').eq(1).click()
    });

    it('Fill Form without labels', () => {
        cy.get('[placeholder="Recipients"]').type('Denny Nur Ramadhan')
        cy.get('[placeholder="Subject"]').type('Lorem Ipsum')
        cy.get('textarea[placeholder="Message"]').type('Lorem ipsum dolor sit amet')
    });

    it('Fill Block form', () => {
      cy.get('#inputFirstName').type('Denny')
      cy.get('#inputLastName').type('Nur')
      cy.get('#inputEmail').type('denny.dand@outlook.com')
      cy.get('#inputWebsite').type('www.denny.com')
    });

    it('Fill Horizontal form', () => {
        cy.get('#inputEmail3').type('denny.dand@outlook.com')
        cy.get('#inputPassword3').type('Killer_queen666')
        cy.get('.custom-checkbox').eq(2).click();
    });

})

import { TestBed, async } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { AppComponent } from './app.component';

describe('AppComponent', () => {

  let component: AppComponent;
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [
        RouterTestingModule
      ],
      declarations: [
        AppComponent
      ],
    }).compileComponents();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
  it('FirstName field validity', () => {
    let errors = {};
    const firstName = component.signUp.controls['firstName'];

    // firstName field is required
    errors = firstName.errors || {};
    expect(errors['required']).toBeTruthy();

     // Set firstName to something
     firstName.setValue('abcd');
     errors = firstName.errors || {};
     expect(errors['required']).toBeFalsy();
     expect(errors['minlength']).toBeTruthy();

      // Set firstName to something correct
      firstName.setValue('abcdde');
      errors = firstName.errors || {};
      expect(errors['required']).toBeFalsy();
      expect(errors['minlength']).toBeFalsy();
  });
  it('LastName field validity', () => {
    let errors = {};
    const lastName = component.signUp.controls['lastName'];

    // LastName field is required
    errors = lastName.errors || {};
    expect(errors['required']).toBeTruthy();

     // Set LastName to something
     lastName.setValue('abcd');
     errors = lastName.errors || {};
     expect(errors['required']).toBeFalsy();
     expect(errors['minlength']).toBeTruthy();

      // Set LastName to something correct
      lastName.setValue('abcdde');
      errors = lastName.errors || {};
      expect(errors['required']).toBeFalsy();
      expect(errors['minlength']).toBeFalsy();
  });

  it('PhoneName field validity', () => {
    let errors = {};
    const phoneNumber = component.signUp.controls['phoneNumber'];

    // phone number field is required
    errors = phoneNumber.errors || {};
    expect(errors['required']).toBeTruthy();

     // Set phone number to something
     phoneNumber.setValue('abcd');
     errors = phoneNumber.errors || {};
     expect(errors['required']).toBeFalsy();
     expect(errors['pattern']).toBeTruthy();

      // Set phone number to something correct
      phoneNumber.setValue('1234567890');
      errors = phoneNumber.errors || {};
      expect(errors['required']).toBeFalsy();
      expect(errors['pattern']).toBeFalsy();
  });


  it('form should be invalid', async(() => {
    component.signUp.controls['firstName'].setValue('Abc');
    component.signUp.controls['lastName'].setValue('XYZ');
    component.signUp.controls['phoneNumber'].setValue('44834838');
    component.signUp.controls['country'].setValue('');
    expect(component.signUp.valid).toBeFalsy();
  }));

  it('form should be valid', async(() => {
    component.signUp.controls['firstName'].setValue('asdfg');
    component.signUp.controls['lastName'].setValue('qwert');
    component.signUp.controls['phoneNumber'].setValue('8787289976');
    component.signUp.controls['country'].setValue('India');
    expect(component.signUp.valid).toBeTruthy();
  }));
});
import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SelectExamComponent } from './select-exam.component';

describe('SelectExamComponent', () => {
  let component: SelectExamComponent;
  let fixture: ComponentFixture<SelectExamComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SelectExamComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SelectExamComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

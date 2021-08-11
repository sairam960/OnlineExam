import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NotClearComponent } from './not-clear.component';

describe('NotClearComponent', () => {
  let component: NotClearComponent;
  let fixture: ComponentFixture<NotClearComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NotClearComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NotClearComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

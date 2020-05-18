import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FindTestComponent } from './find-test.component';

describe('FindTestComponent', () => {
  let component: FindTestComponent;
  let fixture: ComponentFixture<FindTestComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FindTestComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FindTestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

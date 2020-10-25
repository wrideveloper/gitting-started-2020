class info extends HTMLElement {
    connectedCallback(){
        this.render();
    }

    render() {
        this.innerHTML = `
            <main role="main" class="container">
    <div class="row">
      <div class="col-sm-12 col-md-12">
        <div class="card card-default">
          <div class="card-header">Data COVID-19</div>
          <div class="card-body">
            <div><h2>Seluruh Dunia</h2></div>
            <div class="row">
              <div class="col-sm-12 col-md-4">
                <div>
                  <div class="card-body">
                    <h5 class="card-title">Terkonfirmasi</h5>
                    <h3 id="confirmed">0</h3>
                  </div>
                </div>
              </div>
              <div class="col-sm-12 col-md-4">
                <div>
                  <div class="card-body">
                    <h5 class="card-title">Sembuh</h5>
                    <h3 id="recovered">0</h3>
                  </div>
                </div>
              </div>
              <div class="col-sm-12 col-md-4">
                <div>
                  <div class="card-body">
                    <h5 class="card-title">Meninggal</h5>
                    <h3 id="deaths">0</h3>
                  </div>
                </div>
              </div>
            </div>
			<div><h2>Indonesia</h2></div>
            <div class="row">
              <div class="col-sm-12 col-md-4">
                <div>
                  <div class="card-body">
                    <h5 class="card-title">Terkonfirmasi</h5>
                    <h3 id="confirmed1">0</h3>
                  </div>
                </div>
              </div>
              <div class="col-sm-12 col-md-4">
                <div>
                  <div class="card-body">
                    <h5 class="card-title">Sembuh</h5>
                    <h3 id="recovered1">0</h3>
                  </div>
                </div>
              </div>
              <div class="col-sm-12 col-md-4">
                <div>
                  <div class="card-body">
                    <h5 class="card-title">Meninggal</h5>
                    <h3 id="deaths1">0</h3>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="card-footer text-right">Update terakhir : <span id="lastUpdate"></span></div>
        </div>
      </div>
    </div>
  </main>`;
    }
}

customElements.define("info-app", info);